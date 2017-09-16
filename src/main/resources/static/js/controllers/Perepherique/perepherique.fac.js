

  "use strict";

  angular
    .module('ngClassifieds')
    .factory('PerepheriquesFactory', function($http) {

      function getPerepheriques() {
        return $http.get('/Perepheriques');
      }

      return {
    	  getPerepheriques: getPerepheriques
      }
      
    });
    
