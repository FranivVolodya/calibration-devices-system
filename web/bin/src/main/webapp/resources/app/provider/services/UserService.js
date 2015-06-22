angular
    .module('providerModule')
    .factory('UserService', function ($http) {
        return {
            isUsernameAvailable: function (username) {
                return getData('provider/admin/users/available/' + username);
            },
            saveUser: function (userData) {
                return saveData('provider/admin/users/add', userData);
            }
        };

        function getData(url) {
            return $http.get(url)
                .success(function (result) {
                    return result;
                });
        }

        function saveData(url, data) {
            return $http.post(url, data)
                .success(function (response) {
                    return response;
                });
        }
    });
