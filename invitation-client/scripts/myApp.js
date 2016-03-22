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
        }).then(function successCallback(response) {
            // this callback will be called asynchronously
            // when the response is available
            console.log(response)
            if (response.status == 201) {
                $scope.succeed = true
                $scope.user = null
            }
        }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
            console.log(response)
            $scope.failed = true
        });
    }


    $scope.cancel = function (user) {
        console.log(user)
        $http({
            method: 'DELETE',
            url: '/rsvp/rest/guest',
            data: user,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function successCallback(response) {
            // this callback will be called asynchronously
            // when the response is available
            console.log(response)
            if (response.status == 204) {
                $scope.cancelled = true
                $scope.user = null
            }
        }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
            console.log(response)
            $scope.failed = true
        });
    }

}]);