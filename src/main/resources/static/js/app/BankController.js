'use strict'
var module = angular.module('demo.controllers', []);
module.controller("BankController", ["$scope", "BankService",
	function ($scope, BankService) {

		$scope.cities = [];
		$scope.selectedCity = '';
		$scope.banks = [];
		$scope.gridOptions = {
			paginationPageSizes: [10, 25, 50, 75, 100, 250, 500, 1000],
			onRegisterApi: function (gridApi) {
				$scope.gridApi = gridApi;
				$scope.gridApi.grid.registerRowsProcessor($scope.singleFilter, 200);
			},
			paginationPageSize: 10
		};

		$scope.singleFilter = function (renderableRows) {
			var matcher = new RegExp($scope.filterValue, 'i');
			renderableRows.forEach(function (row) {
				var match = false;
				['bank_name', 'branch', 'ifsc', 'address', 'city', 'district', 'state'].forEach(function (field) {
					if (row.entity[field].match(matcher)) {
						match = true;
					}
				});
				if (!match) {
					row.visible = false;
				}
			});
			return renderableRows;
		};

		$scope.gridOptions.columnDefs = [
			{ name: 'id', width: 75 },
			{ name: 'bank_name' },
			{ name: 'branch' },
			{ name: 'I_F_S_C', field: 'ifsc' },
			{ name: 'address', width: 350 },
			{ name: 'city', enableSorting: false },
			{ name: 'district', enableSorting: false },
			{ name: 'state', enableSorting: false }
		];
		$scope.myPromise = BankService.getCities().then(function (value) {
			if (value.data.success) {
				$scope.cities = value.data.response;
				$scope.selectedCity = $scope.cities[0] || '';
				getBankData($scope.selectedCity);
			}
		}, function (reason) {
			console.log("error occured");
		}, function (value) {
			console.log("no callback");
		});

		$scope.cityChanged = (selectedCity) => {
			getBankData(selectedCity);
		}

		$scope.$watch('filterValue', function (newvalue, oldvalue) {
			$scope.filter();
		});

		$scope.filter = function () {
			$scope.gridApi.grid.refresh();
		};

		function getBankData(city) {
			$scope.myPromise = BankService.findByCity(city).then(function (value) {
				$scope.banks = value.data.response;
				$scope.gridOptions.data = $scope.banks;
			}, function (reason) {
				console.log("error occured");
			}, function (value) {
				console.log("no callback");
			});
		}
	}]);