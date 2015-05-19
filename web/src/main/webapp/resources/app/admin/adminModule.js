angular.module('adminModule', ['spring-security-csrf-token-interceptor',
    'ui.bootstrap', 'ui.router'])
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise('/');
            $stateProvider
                .state('main-panel', {
                    url: '/',
                    templateUrl: '/resources/app/admin/views/main-panel.html'
                })
                .state('organizations-panel', {
                    url: '/organizations',
                    templateUrl: '/resources/app/admin/views/organizations-panel.html'
                })
                .state('users-panel', {
                    url: '/users',
                    templateUrl: '/resources/app/admin/views/users-panel.html'
                })
                .state('address-panel', {
                    url: '/address',
                    templateUrl: '/resources/app/admin/views/address-panel.html'
                })
                .state('devices-panel', {
                    url: '/devices',
                    templateUrl: '/resources/app/admin/views/devices-panel.html'
                })
                .state('settings-panel', {
                    url: '/settings',
                    templateUrl: '/resources/app/admin/views/settings-panel.html'
                })
                .state('calibration-test-panel', {
                    url: '/calibration-tests',
                    templateUrl: '/resources/app/admin/views/calibration-test-panel.html'
                });

            }]);

angular.module('adminModule').run(function(paginationConfig){
    paginationConfig.firstText = 'Перша';
    paginationConfig.previousText = 'Попередня';
    paginationConfig.nextText = 'Наступна';
    paginationConfig.lastText = 'Остання';
});

define([
    'controllers/TopNavBarController',
    'controllers/MainPanelController',
    'controllers/UsersController',
    'controllers/OrganizationController',
    'controllers/CalibrationTestController',
    'services/CalibrationTestService',
    'services/OrganizationService',
    'services/StatisticService'
], function () {});
