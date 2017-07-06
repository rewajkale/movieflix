/**
 * Created by rewak on 7/6/2017.
 */
(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('MovieListController', MovieListController);

    MovieListController.$inject = ['movieService'];

    function MovieListController(movieService) {
        var movieListVm = this;
        console.log('in MovieListController');

        init();
        movieListVm.getActiveId = getActiveId;
        movieListVm.setActiveId = setActiveId;
        movieListVm.changeTabs = changeTabs;
        movieListVm.getActiveIndex = getActiveIndex;

        function getActiveId() {
            return movieListVm.activeId;
        }

        function getActiveIndex() {
            for (var i = 0; i < movieListVm.movies.length; i++) {
                if (movieListVm.movies[i].id === movieListVm.activeId) {
                    return i;
                }
            }
        }

        function setActiveId(id) {
            movieListVm.activeId = id;
        }

        function changeTabs(tab) {

            for (var i = 0; i < movieListVm.movies.length; i++) {
                if (movieListVm.movies[i].type === tab) {
                    movieListVm.setActiveId(movieListVm.movies[i].id);
                    break;
                }
            }
            movieListVm.active_tab = tab;
        }

        function init() {
            movieListVm.active_tab = 'movie';
            movieListVm.activeId = '-1';

            movieService.getMovies()
                .then(function(data) {
                    movieListVm.movies = data;
                    for (var i = 0; i < movieListVm.movies.length; i++) {
                        if (movieListVm.movies[i].type == movieListVm.active_tab) {
                            movieListVm.setActiveId(movieListVm.movies[i].id);
                            break;
                        }
                    }
                })
                .catch(function(error) {
                    console.log(error);
                });
        }

    }
})();