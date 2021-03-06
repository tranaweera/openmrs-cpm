define(['angular', 'config', 'filters', 'directives', 'services'], function(angular, config) {

  var cpm = angular.module('cpm-review', ['cpm.filters', 'cpm.directives', 'cpm.services']);

  cpm.config(['$routeProvider', function($routeProvider){
    $routeProvider.
      when('/', {controller: 'ListIncomingProposalsCtrl', templateUrl: config.resourceLocation + '/ListIncomingProposals.html'}).
      when('/edit/:proposalId', {controller: 'ReviewProposalCtrl', templateUrl: config.resourceLocation + '/ReviewProposal.html'});
  }]);

  return cpm;
});
