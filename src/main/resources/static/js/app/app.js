'use strict'
var demoApp = angular.module('demo', [ 'ui.bootstrap', 'ui.grid',
		'ui.grid.pagination', 'ui.grid.resizeColumns', 'demo.controllers',
		'demo.services', 'cgBusy']);

demoApp.constant("CONSTANTS", {
	getCities : "/banks/getCities",
	findByCity : "/banks/findByCity"
});