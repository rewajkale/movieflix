/**
 * Created by rewak on 7/6/2017.
 */
(function() {
    'use strict';

    angular.module('movieflix', ['ngAnimate', 'ui.bootstrap']);

    angular.module('movieflix').run(moduleRun);
    function moduleRun() {
        console.log('App Started');
    }
})();