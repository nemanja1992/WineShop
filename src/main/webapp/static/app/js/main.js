var wineShop = angular.module("wineShop", ['ngRoute']);

wineShop.config(['$routeProvider', function ($routeProvider){
	$routeProvider.when('/',{
		templateUrl: '/static/app/html/partial/wine.html'
	}).when('/wine/edit/:id',{
		templateUrl: '/static/app/html/partial/edit-wine.html'
    }).when('/wine/gallery',{
        templateUrl: '/static/app/html/partial/gallery.html'
    }).when('/wine/about',{
        templateUrl: '/static/app/html/partial/about.html'
    }).when('/wine/contact',{
        templateUrl: '/static/app/html/partial/contact.html'
	}).otherwise({
		redirectTo: '/'
	});
}]);
wineShop.controller("indexCtrl", function($scope,  $location){
    $scope.gallery= function(){
        $location.path('/wine/gallery')
    }
    $scope.home= function(){
        $location.path('/')
    }
    $scope.about= function(){
        $location.path('/wine/about')
    }
    $scope.contact= function(){
        $location.path('/wine/contact')
    }
});
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

    $scope.findWine={};
    $scope.findWine.name="";
    $scope.findWine.vintage="";
    $scope.findWine.minPrice="";
    $scope.findWine.maxPrice="";
    $scope.findWine.companyId="";


	var getWines = function(){

		var config = {params: {}};

		config.params.pageNum = $scope.pageNum;

		if ($scope.findWine.name != "") {
            config.params.name = $scope.findWine.name;
        }
        if ($scope.findWine.vintage != "") {
            config.params.vintage = $scope.findWine.vintage;
        }
        if ($scope.findWine.minPrice != "") {
            config.params.minPrice = $scope.findWine.minPrice;
        }
        if ($scope.findWine.maxPrice != "") {
            config.params.maxPrice = $scope.findWine.maxPrice;
        }

        

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
		getCompany();
	};
	$scope.clear =function(){
		$scope.findWine="";
	}

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

wineShop.controller("editWineCtrl", function($scope, $http,$routeParams, $location){

    var base_url_wine ="/api/wine";
    var base_url_company="/api/company";
    var base_url_type="/api/type";

    $scope.companies = [];
    $scope.types = [];
    $scope.oldWine = null;

    var getOldWines = function(){

        $http.get(base_url_wine + "/" + $routeParams.id)
            .then(function success(data){
                $scope.oldWine= data.data;
            });
    }
    getOldWines();

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

    
    getCompany();
    getType();

    $scope.edit = function(){
        $http.put(base_url_wine + "/" + $scope.oldWine.id, $scope.oldWine)
            .then(function success(data){
                alert("Edit success!");
                $location.path("/");
            });
    }



});


