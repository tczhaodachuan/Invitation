/**
 * Created by dachuan on 3/17/16.
 */
var myApp = angular.module('myApp',[]);

myApp.controller('formController', ['$scope','$http', function($scope,$http) {
    $scope.save = function(user)
    {
        console.log(user)
        $http({
            method: 'POST',
            url: '/rsvp',
            data: user
        }).then(function successCallback(response) {
            // this callback will be called asynchronously
            // when the response is available
            $scope.succeed=true
        }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
            $scope.failed=true
        });
    }

}]);