/**
 * Created by rewak on 7/6/2017.
 */
(function() {
    'use strict';

    angular
        .module('movieflix')
        .service('movieService', movieService);

    movieService.$inject = ['$http', '$q'];

    function movieService($http, $q) {
        var self = this;
        console.log("In Movie service");
        self.getMovies = getMovies;
        self.getUser = getMovie;
        self.getActiveMovie = getActiveMovie;
        //self.createUser = createUser;

        function getMovies() {
            return $http.get('http://localhost:8080/movieflix/api/movies')
                .then(successFn, errorFn);

        }

        function getActiveMovie() {
            console.log("Getting active movie");
            return self.activeMovie;
            //return $http.get('http://mocker.egen.io/users/' + id)
            //  .then(successFn, errorFn);
        }

        function getMovie(id) {
            //return $http.get('http://mocker.egen.io/users/' + id)
            //  .then(successFn, errorFn);
        }

        function successFn(response) {
            self.movies = response.data;
            self.activeMovie = self.movies[0];
            return self.movies; //RESOLVE
        }

        function errorFn(error) {
            return $q.reject(error.status); //REJECT
        }
    }
})();