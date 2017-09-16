(function() {

  "use strict";

  angular
    .module('ngClassifieds')
    .controller('classifiedsController', function($scope, $http,$state,$uibModal, $stateParams, classifiedsFactory) {

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


      classifiedsFactory.getClassifieds().then(function(data) {
        vm.classifieds = data.data;
        
      });

      function Historique(row){
    	  vm.classifiedH = row;
       	  $uibModal.open({
    		  animation: $scope.animationsEnabled,
    		  templateUrl: 'js/controllers/logiciel/classifieds.historique.tpl.html',
              controller: 'HistoriqueController as vm',
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
		  templateUrl: 'js/controllers/logiciel/edit_logiciel/logiciel.edit.tpl.html',
          controller: 'editLogicielController as vm',
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
    		  templateUrl: 'js/controllers/logiciel/new_logiciel/logiciel.new.tpl.html',
              controller: 'newLogicielController as vm',
              size:"lg"
    	  }
    	  );
      }

        
        function deleteLog (classified) {
            vm.num=classified;
        	console.log(vm.num);
        	var url = '/DeleteLogiciel?numL='+vm.num;
           
                      	
        	$http.delete(url).then(function (response) {
        	    console.log('all is good', response.data);
				$state.reload();

        	}, function (error) {
        		$state.go("403");
        	    console.log('an error occurred', error.data);
        	});
        	
        	
        	
        	
         

          
            
        }
        
        
        
        
        
        
        
        

    });

})();