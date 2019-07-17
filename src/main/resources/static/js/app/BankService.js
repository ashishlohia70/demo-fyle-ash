'use strict'
angular.module('demo.services', []).factory('BankService',
	["$http", "CONSTANTS", function ($http, CONSTANTS) {
		let service = {};
		service.getCities = function () {
			return $http.get(CONSTANTS.getCities);
		}
		service.findByCity = function (city) {
			return $http.get(`${CONSTANTS.findByCity}?city=${city}`, {cache: true});
		}
		return service;
	}]);