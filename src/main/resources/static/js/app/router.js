'use strict';

angular.module('secure-angular-app.router', ['ngRoute',
    'secure-angular-app.message-controllers'
])

.config(['$routeProvider', function($routeProvider) {
	$routeProvider

    .when('/', {
        templateUrl : 'home.html',
        controller : 'appController',
        controllerAs: 'controller'
    }).when('/login', {
        templateUrl : 'login.html',
        controller : 'loginController',
        controllerAs: 'controller'
    }).otherwise('/login');

}]);