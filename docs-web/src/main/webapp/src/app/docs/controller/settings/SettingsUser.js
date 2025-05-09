'use strict';

/**
 * Settings user page controller.
 */
angular.module('docs').controller('SettingsUser', function($scope, $state, Restangular) {
  /**
   * Load users from server.
   */
  $scope.loadUsers = function() {
    Restangular.one('user/list').get({
      sort_column: 1,
      asc: true
    }).then(function(data) {
      $scope.users = data.users;
    });
  };

    /**
   * Load register.
   */
    $scope.loadRegister = function() {
        Restangular.one('user/register').get({
          sort_column: 1,
          asc: true
        }).then(function(data) {
          $scope.registrations = data.users;
        });
      };
  
  $scope.loadUsers();
  $scope.loadRegister();
  /**
   * Edit a user.
   */
  $scope.editUser = function(user) {
    $state.go('settings.user.edit', { username: user.username });
  };

   /**
   * approve a registration.
   */
   $scope.approveRegistration = function(registration) {
    const data = $.param({
        id: registration.id,
        username: registration.username,
        password: registration.password
    });

    Restangular
        .one('user')
        .one('approve')
        .customPOST(data, '', {}, {
            'Content-Type': 'application/x-www-form-urlencoded'
        }).then(function(response) {
            console.log('Success:', response);
        }, function(error) {
            console.error('Error:', error);
        });
};



});