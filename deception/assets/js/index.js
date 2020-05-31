var app = angular.module('index', [])
var date = new Date();
app.controller('indexController',
    function ($scope, $http, $filter) {
        $scope.data = new Array;
        $http({
            method: 'GET',
            url: '/serenity-bdd-project/target/cucumber.json',
            dataType: 'json',
            contentType: "application/json"
        }).then(function (response) {
            $scope.datas = response.data;
            $scope.CurrentDate = $filter('date')(new Date(), 'HH:mm:ss');
            console.log($scope.datas)
        }, function (error) {

        });
    });