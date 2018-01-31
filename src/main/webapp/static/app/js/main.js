var wineShop = angular.module("wineShop", ['ngRoute']);

wineShop.config(['$routeProvider', function ($routeProvider){
	$routeProvider.when('/',{
		templateUrl: '/static/app/html/partial/wine.html'
	}).otherwise({
		redirectTo: '/'
	});
}]);