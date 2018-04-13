
var cartApp = angular.module ("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http){

    $scope.refreshCart = function (cartId) {
        $http.get('/BNB/rest/cart/'+$scope.cartId).success(function (data) {
            $scope.cart=data;
        });
    };

    $scope.clearCart = function () {
        $http.delete('/BNB/rest/cart/'+$scope.cartId).success($scope.refreshCart($scope.cartId));
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function (roomID) {
        $http.put('/BNB/rest/cart/add/'+roomID).success(function (data) {
            $scope.refreshCart($http.get('/BNB/rest/cart/cartId'));
            alert("Room successfully added to the cart!")
        });
    };

    $scope.removeFromCart = function (roomID) {
        $http.put('/BNB/rest/cart/remove/'+roomID).success(function (data) {
            $scope.refreshCart($http.get('/eMusicStore/rest/cart/cartId'));
        });
    };
});