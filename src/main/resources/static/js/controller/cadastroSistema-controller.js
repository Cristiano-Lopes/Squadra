appSistema.controller("cadastroController", function($scope, $http) {
	$scope.sistemas=[];
	$scope.sistema = {};

	$scope.salvarSistema = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8084/sistemas',
			data : $scope.sistema
		}).then(function(response) {	
			$scope.frmSistema.$setDirty();
			if($scope.frmSistema.$invalid)
				return;						
			$scope.sistemas.push(response.data)			
			$scope.sistema={};
						
			console.log(response.data);
			console.log(response.status);
		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	}
	

	
	$scope.salvarSistema();
		
});


