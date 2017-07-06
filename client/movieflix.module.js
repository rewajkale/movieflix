/**
 * Created by rewak on 7/6/2017.
 */
(function() {
    'use strict';

    angular
        .module('movieflix', ['ngMessages', 'ngRoute'])
        .config(moduleConfig)
        .run(moduleRun);

    moduleConfig.$inject = ['$routeProvider'];

    function moduleConfig($routeProvider) {
        $routeProvider
            .when('/movie-list', {
                templateUrl: 'movie-list.tmpl.html',
                controller: 'MovieListController',
                controllerAs: 'movieListVm'
            })
            .otherwise({
                redirectTo: '/movie-list'
            });
    }

    moduleRun.$inject = [];

    function moduleRun() {
        console.log('App Started');
    }
})();