'use strict';

angular.module('secure-angular-app', [
  	'secure-angular-app.router',
	'secure-angular-app.security-service',
	'secure-angular-app.util',
  	'ui.bootstrap',
  	'underscore'
])

.factory('authInterceptor', ['$q', '$rootScope', '$location', function($q, $rootScope, $location) {
	var responseError = function(response) {
		if (response.status === 401) {
			$location.path('/login');
			return $q.reject(response);
		}
		return response;
	};

	return {
		responseError: responseError
	}
}])

.config(['$httpProvider', function($httpProvider) {
	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
	$httpProvider.interceptors.push('authInterceptor');
}])

.constant('BASE_API_ENDPOINT', '')

.controller('appController', ['$scope', '$location', 'securityService', function ($scope, $location, securityService) {
	//$scope.updateCurrentActiveLink = function (clickedLink) {
	//	$scope.currentActiveLink = clickedLink;
	//};

	//$scope.isCurrentActiveLink = function (link) {
	//	return $scope.currentActiveLink === link;
	//};

	//$scope.$on(commonService.EVENT_TYPES.CURRENT_PRINCIPAL_CHANGE_EVENT, function() {
	//	console.log("***** " + commonService.EVENT_TYPES.CURRENT_PRINCIPAL_CHANGE_EVENT);
	//	$scope.currentPrincipal = commonService.getProperty(commonService.CURRENT_PRINCIPAL_KEY);
	//});

	$scope.getCurrentPrincipal = function() {
		securityService.currentPrincipal();
	};

	$scope.logout = function() {
		securityService.logout();
	};

	//$scope.goTo = function(view) {
	//	$location.path(view);
	//};

	var init = function() {
		if($location.path() != '' && $location.path() != '/login') {
			$scope.getCurrentPrincipal();
		}
	};

	init();

}])

.controller('loginController', ['$scope', '$location', 'securityService', function ($scope, $location, securityService) {
	$scope.login = function() {
		securityService.login($scope.auth, function(response, success) {
			if (success) {
				$location.path('/bla');
			}
		});
	};

	var init = function() {
		$scope.auth = {};
	};

	init();
}]);