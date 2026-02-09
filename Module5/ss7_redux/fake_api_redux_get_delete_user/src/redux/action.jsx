// Get all users
export const GET_USERS = 'GET_USERS';
export const GET_USERS_SUCCESS = 'GET_USERS_SUCCESS';
export const GET_USERS_FAILED = 'GET_USERS_FAILED';

// Add User
export const ADD_USER = 'ADD_USER';
export const ADD_USER_SUCCESS = 'ADD_USER_SUCCESS';
export const ADD_USER_FAILED = 'ADD_USER_FAILED';

// Delete user
export const DELETE_USER = 'DELETE_USER';
export const DELETE_USER_SUCCESS = 'DELETE_USER_SUCCESS';
export const DELETE_USER_FAILED = 'DELETE_USER_FAILED';

export const getUsers = () => ({
  type: GET_USERS
});

export const getUsersSuccess = (users) => ({
  type: GET_USERS_SUCCESS,
  payload: users
});

export const getUsersFailed = (error) => ({
  type: GET_USERS_FAILED,
  payload: error
});

export const addUser = (user) => ({
    type: ADD_USER,
    payload: user
})

export const addUserSuccess = (user) => ({
    type: ADD_USER_SUCCESS,
    payload: user
})

export const addUserFailed = (error) => ({
    type: ADD_USER_FAILED,
    payload: error
})

export const deleteUser = (userId) => ({
  type: DELETE_USER,
  payload: userId
});

export const deleteUserSuccess = (userId) => ({
  type: DELETE_USER_SUCCESS,
  payload: userId
});

export const deleteUserFailed = (error) => ({
  type: DELETE_USER_FAILED,
  payload: error
});
