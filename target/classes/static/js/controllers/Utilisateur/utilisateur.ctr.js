(function() {

  "use strict";

  angular
    .module('ngClassifieds')
    .controller('UsersController', function($scope, $http,$state,$uibModal, $stateParams, UsersFactory) {

      var vm = this;
      
   vm.EditLog=EditLog;    
   vm.deleteLog=deleteLog;
   vm.addItem=addItem;
   vm.Historique=Historique;
   
   
	
		vm.loggedU=$http.get('/getLogedUser');
	

		$http({
			  method: 'GET',
			  url: '/getLogedUser'
			}).then(function successCallback(data) {
			    // this callback will be called asynchronously
			    // when the response is available
				vm.loggedU=data;
			  }, function errorCallback(data) {
			    console.log("eroooooooor");
			  });
	

		
 console.log(vm.loggedU);
   
   
   

   UsersFactory.getUsers().then(function(data) {
        vm.classifieds = data.data;
        
      });

      function Historique(row){
    	  vm.classifiedH = row;
       	  $uibModal.open({
    		  animation: $scope.animationsEnabled,
    		  templateUrl: 'js/controllers/Utilisateur/utilisateur.historique.tpl.html',
              controller: 'HistoriqueUSerController as vm',
              size:"sm",
              resolve: {
            	    classifiedH: function() {
            	      
            	      return vm.classifiedH;
            	    }
            	  }
              
    	  });
    	  
      }
      
      
     function EditLog(row){
    	  
         vm.classified = row;

   	  $uibModal.open({
		  animation: $scope.animationsEnabled,
		  templateUrl: 'js/controllers/Utilisateur/edit_utilisateur/utilisateur.edit.tpl.html',
          controller: 'editUserController as vm',
          size:"lg",
          resolve: {
        	    classified: function() {
        	      
        	      return vm.classified;
        	    }
        	  }
          
	  }
	  );
    	 
     }
		

      function addItem(){
    	 // $state.go('Listlogicieladd');
    	  $uibModal.open({
    		  animation: $scope.animationsEnabled,
    		  templateUrl: 'js/controllers/Utilisateur/new_utilisateur/utilisateur.new.tpl.html',
              controller: 'newUserController as vm',
              size:"lg"
    	  }
    	  );
      }

        
        function deleteLog (classified) {
            vm.num=classified;
        	console.log(vm.num);
        	var url = '/DeleteUser?numU='+vm.num;
           
                      	
        	$http.delete(url).then(function (response) {
        	    console.log('all is good', response.data);
				$state.reload();

        	}, function (error) {
        	    console.log('an error occurred', error.data);
        	    $state.go("403");
        	});
        	
        	
        	
        	
         

          
            
        }
        
        
        
        
        
        
        
        

    });

})();