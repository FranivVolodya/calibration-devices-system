angular
	.module('providerModule')
	.controller('MainPanelController',
			[ '$scope', '$http', '$log', function($scope, $http, $log) {
			
		         $http.get('provider/admin/users/role')
	                .success(function (data){
	                	$scope.s = data;
	                var a = JSON.parse(data);
	                	$scope.s = a;
	                	a.admin;
	                	alert(a.admin);
	                	if (a.admin === 'admin') {
					        	$scope.show = true
				          	} else
					
						$scope.show = false
	                	 return data;
	                })
	                .error(function (err) {
	                    return err;
	                });
			} ]);
			