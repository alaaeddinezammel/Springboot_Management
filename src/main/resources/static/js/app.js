(function() {
	"use strict";

	angular
			.module(
					'ngClassifieds',
					[ 'ui.router', 'angularUtils.directives.dirPagination',
							'ui.bootstrap', 'ui.tree' ])
			.config(
					function($stateProvider, $urlRouterProvider) {

						$urlRouterProvider.otherwise('/Home');

						$stateProvider
								.state(
										'Listlogiciel',
										{
											url : '/Listlogiciel',
											templateUrl : 'js/controllers/logiciel/classifieds.tpl.html',
											controller : 'classifiedsController as vm'
										})
								.state(
										'listPerepherique',
										{
											url : '/listPerepherique',
											templateUrl : 'js/controllers/Perepherique/perepherique.tpl.html',
											controller : 'PerpheriquesController as vm'
										})
								.state(
										'listEmplacement',
										{
											url : '/listEmplacement',
											templateUrl : 'js/controllers/Emplacement/emplacement.tpl.html',
											controller : 'listEMPLController as vm',

										})
								.state(
										'Home',
										{
											url : '/Home',
											templateUrl : 'js/controllers/Home.tpl.html'

										})
								.state(
										'Fournisseurs',
										{
											url : '/Fournisseurs',
											templateUrl : 'js/controllers/Fournisseurs/fournisseur.tpl.html',
											controller : 'listFournisseurController as vm'
										})
								.state(
										'Machine',
										{
											url : '/Machines',
											templateUrl : 'js/controllers/Machine/machine.tpl.html',
											controller : 'machineController as vm'
										})
								.state(
										'Machine&Logiciel',
										{
											url : '/Machines&Logiciel',
											templateUrl : 'js/controllers/logiciel/LogicielMachine.tpl.html',
											controller : 'logicielMahcineController as vm'
										})
								.state(
										'Machine&Perepherique',
										{
											url : '/Machine&Perepherique',
											templateUrl : 'js/controllers/Perepherique/perepheriqueMachine.tpl.html',
											controller : 'logicielPerepheriqueController as vm'
										})
								.state(
										'CarteVideo',
										{
											url : '/CarteVideo',
											templateUrl : 'js/controllers/CarteV/cartV.tpl.html',
											controller : 'listCVController as vm'
										})
								.state(
										'DDUR',
										{
											url : '/DDUR',
											templateUrl : 'js/controllers/DDUR/ddur.tpl.html',
											controller : 'listDDURController as vm'
										})
								.state(
										'Ecran',
										{
											url : '/Ecran',
											templateUrl : 'js/controllers/Ecrans/ecran.tpl.html',
											controller : 'listECRANController as vm'
										})
								.state(
										'garentie',
										{
											url : '/garentie',
											templateUrl : 'js/controllers/Garentie/garentie.tpl.html',
											controller : 'listGarentieController as vm'
										})
								.state(
										'maintenance',
										{
											url : '/maintenance',
											templateUrl : 'js/controllers/Maintenance/maintenance.tpl.html',
											controller : 'listManitController as vm'
										})
								.state(
										'marque',
										{
											url : '/marque',
											templateUrl : 'js/controllers/Marque/marque.tpl.html',
											controller : 'listmarQUEController as vm'
										})
								.state(
										'Machine&User',
										{
											url : '/Machines&user',
											templateUrl : 'js/controllers/Utilisateur/utilisateurMachine.tpl.html',
											controller : 'UserMahcineController as vm'
										})
								.state(
										'Utilisateurs',
										{
											url : '/Utilisateurs',
											templateUrl : 'js/controllers/Utilisateur/utilisateur.tpl.html',
											controller : 'UsersController as vm'
										})
								.state(
										'403',
										{
											url : '/403',
											templateUrl : 'js/controllers/Utilisateur/utilisateur403.tpl.html',
										});

					});

})();