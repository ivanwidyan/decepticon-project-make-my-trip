var app = angular.module('myApp', []);
app.controller('myController',
    function ($scope, $http) {
        $scope.datas = new Array;
        $http({
            method: 'GET',
             url: 'data/json/master.json',
            dataType: 'json',
            contentType: "application/json"
        }).then(function (response) {
            $scope.datas = response.data;
            console.log($scope.datas);
        }, function (error) {

        });
    });