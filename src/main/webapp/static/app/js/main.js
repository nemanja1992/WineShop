var wineShop = angular.module("wineShop", ['ngRoute']);

wineShop.config(['$routeProvider', function ($routeProvider){
	$routeProvider.when('/',{
		templateUrl: '/static/app/html/partial/wine.html'
	}).when('/wine/edit/:id',{
		templateUrl: '/static/app/html/partial/edit-wine.html'
	}).otherwise({
		redirectTo: '/'
	});
}]);

wineShop.controller("wineCtrl", function($scope, $http, $location){

	var base_url_wine="/api/wine";
	var base_url_company="/api/company";
	var base_url_type="/api/type";

	$scope.pageNum = 0;
	$scope.totalPages = 0;

	$scope.companies = [];
	$scope.types = [];
	$scope.wines = [];

	$scope.newWine = {};
	$scope.newWine.name = "" ;
	$scope.newWine.alcoholPercent = "" ;
	$scope.newWine.price = "" ;
	$scope.newWine.quantity = "" ;
	$scope.newWine.vintage = "" ;
	$scope.newWine.companyId = "" ;
	$scope.newWine.typeId = "";

	var getWines = function(){

		var config = {params: {}};

		config.params.pageNum = $scope.pageNum;

		$http.get(base_url_wine, config)
		.then(function success(data){
			$scope.wines = data.data;
			$scope.totalPages = data.headers('totalPages');
		});
	};

	var getCompany = function(){

		$http.get(base_url_company)
		.then(function success(data){
			$scope.companies = data.data;
		});
	};
	var getType = function(){

		$http.get(base_url_type)
		.then(function success(data){
			$scope.types = data.data;
		});
	};

	getWines();
	getCompany();
	getType();

	$scope.preview = function(){
		if($scope.pageNum > 0) {
			$scope.pageNum = $scope.pageNum - 1;
			getWines();
		}
	};

	$scope.next = function(){
		if($scope.pageNum < $scope.totalPages - 1){
			$scope.pageNum = $scope.pageNum + 1;
			getWines();
		}
	};
	$scope.find = function () {
		$scope.pageNum = 0;
		getWines();
	};

	$scope.edit = function(id){
		$location.path('/wine/edit/' + id);
	};

	$scope.delete = function(id){
		$http.delete(base_url_wine + "/" + id).then(
				function success(data){
					getWines();
				},
				function error(data){
					alert("Neuspesno brisanje!");
					console.log(data);
				}
		);

	};
	$scope.add = function () {
		$http.post(base_url_wine, $scope.newWine)
		.then(function success(data){
			console.log(data.data);
			alert("Success adding");
			getWines();

			$scope.newWine.name = "" ;
			$scope.newWine.alcoholPercent = "" ;
			$scope.newWine.price = "" ;
			$scope.newWine.quantity = "" ;
			$scope.newWine.vintage = "" ;
			$scope.newWine.companyId = "" ;
			$scope.newWine.typeId = "";
		});
	};

});