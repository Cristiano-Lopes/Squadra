//Criação do modulo principal da aplicação
var appSistema = angular.module("appSistema",['ngRoute']);

appSistema.config(function($routeProvider, $locationProvider){
	
	$routeProvider
	.when("/pesquisa",{templateUrl:'view/pesquisarSistema.html', controller:'pesquisaController'})
	.when("/cadastro",{templateUrl:'view/cadastrarSistema.html', controller:'cadastroController'})
	.when("/",{templateUrl:'view/start.html', controller:'startController'})
	.otherwise({redirectTo:'/'});
	
	$locationProvider.html5Mode(true);
});

