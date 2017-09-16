

  "use strict";

  angular
    .module('ngClassifieds')
    .factory('classifiedsFactory', function($http) {

      function getClassifieds() {
        return $http.get('/logiciels');
      }

      return {
        getClassifieds: getClassifieds
      }
      
    });
    
