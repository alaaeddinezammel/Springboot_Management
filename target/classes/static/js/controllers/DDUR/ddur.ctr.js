(function() {

  "use strict";

  angular
    .module('ngClassifieds')
    .controller('listDDURController', function($scope, $http,$state,$uibModal, $stateParams, DDURFactory) {

      var vm = this;
      
   vm.EditLog=EditLog;    
   vm.deleteLog=deleteLog;
   vm.addItem=addItem;
  
   
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

   

   DDURFactory.getDD().then(function(data) {
        vm.classifieds = data.data;
        
      });


      
      
     function EditLog(row){
    	  
         vm.classified = row;

   	  $uibModal.open({
		  animation: $scope.animationsEnabled,
		  templateUrl: 'js/controllers/DDUR/edit_ddur/ddur.edit.tpl.html',
          controller: 'editddurController as vm',
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
    		  templateUrl: 'js/controllers/DDUR/new_ddur/ddur.new.tpl.html',
              controller: 'newEddurController as vm',
              size:"lg"
    	  }
    	  );
      }

        
        function deleteLog (classified) {
            vm.num=classified;
        	console.log("--------------:D"+vm.num);
        	var url = '/DeleteDD?numDD='+vm.num;
        
                      	
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