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
}]);


myApp.controller('navController', ['$scope', function ($scope) {
    $scope.click = function () {
        $(".nav-container").toggleClass("showNav hideNav").removeClass("hidden");
        $(".btn-nav").toggleClass("animated");
    }
}]);

myApp.controller('mapNavController', ['$window', '$scope', function ($window, $scope) {
    $scope.click = function () {
        $window.location.href = 'http://map.baidu.com/mobile/webapp/place/linesearch/foo=bar/end=word%3D%25E6%25B2%25B3%25E5%258D%2597%25E7%259C%2581%25E9%2583%2591%25E5%25B7%259E%25E5%25B8%2582%25E9%2587%2591%25E6%25B0%25B4%25E5%258C%25BA%25E9%2583%2591%25E6%25B1%25B4%25E8%25B7%25AF162%25E5%258F%25B7/?third_party=uri_api'; //You should have http here.
    }
}]);
