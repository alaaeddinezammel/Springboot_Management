

  "use strict";

  angular
    .module('ngClassifieds')
    .factory('FournisseurFactory', function($http) {

      function getFournisseurs() {
        return $http.get('/Fournisseurs');
      }

      return {
        getFournisseurs: getFournisseurs
      }
      
    });
    
