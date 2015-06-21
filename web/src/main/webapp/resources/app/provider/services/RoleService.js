andular
	.module('providerModule')
	.factory('RoleService', ['$http', '$log', function($http, $log){
		
		return{
			getRole: function() {
				return getData('role');
			} 
		}
		function getData(url) {

            $log.info(url);

            return $http.get('provider/'+url)
                .success(function (data) {
                    return data;
                })
                .error(function (err) {
                    return err;
                });
			
		}
	}])