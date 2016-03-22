/**
 * Created by dachuan on 3/17/16.
 */
var myApp = angular.module('myApp', []);

myApp.controller('formController', ['$scope', '$http', function ($scope, $http) {
    $scope.save = function (user) {
        console.log(user)
        $http({
            method: 'POST',
            url: '/rsvp/rest/guest',
            data: user,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function successCallback(response, status) {
            // this callback will be called asynchronously
            // when the response is available
            console.log(response)
            console.log(status)
            $scope.succeed = true
        }, function errorCallback(response, status) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
            console.log(response)
            console.log(status)
            $scope.failed = true
        });
    }

}]);