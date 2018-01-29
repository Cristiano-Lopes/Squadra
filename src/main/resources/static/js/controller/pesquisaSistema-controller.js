appSistema.controller("pesquisaController", function($scope, $http) {
	$scope.sistemas = [];
	$scope.sistema = {};
	
	

	$scope.carregarSistema = function(sistema) {
		$http({
			method : 'GET',
			url : 'http://localhost:8084/sistemas',
		}).then(function(response) {
			$scope.sistemas = response.data;

			console.log(response.data);
			console.log(response.status);
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};


	$scope.carregarSistema();
});
