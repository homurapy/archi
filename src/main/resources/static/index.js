angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/store/api/v1';

    $scope.saveItem= function () {
        console.log($scope.NewItem)
        $http.post(contextPath + '/product', $scope.NewItem)
            .then(function (resp){
                $scope.NewItem = null
                $scope.fillTable();
            })

    };
    $scope.deleteItemById = function (id) {
        $http.delete(contextPath + '/product/' + id)
            .then(function (){
                $scope.fillTable();
            });
    };
    $scope.fillTable = function (pageIndex = 1) {
        $http({
            url: contextPath + '/product',
            method: 'GET',
        }).then(function (response) {
            $scope.Items = response.data;
        });
    };
    $scope.fillTable();
});