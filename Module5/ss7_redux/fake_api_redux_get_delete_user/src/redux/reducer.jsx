import { combineReducers } from 'redux';
import {
    GET_USERS,
    GET_USERS_SUCCESS,
    GET_USERS_FAILED,
    DELETE_USER,
    DELETE_USER_SUCCESS,
    DELETE_USER_FAILED, ADD_USER, ADD_USER_SUCCESS, ADD_USER_FAILED
} from './action';

const initialState = {
  users: [],
  loading: false,
  error: null,
  deleting: false
};

export const userReducer = (state = initialState, action) => {
    switch (action.type) {
        // --- GET USERS ---
        case GET_USERS:
          return {
            ...state,
            loading: true,
            error: null
          };

        case GET_USERS_SUCCESS:
          return {
            ...state,
            loading: false,
            users: action.payload,
            error: null
          };

        case GET_USERS_FAILED:
          return {
            ...state,
            loading: false,
            error: action.payload
          };

        // --- ADD USER ---
        case ADD_USER:
            return {
                ...state,
                loading: true,
                users: [...state.users, action.payload],
                error: null
            }

        case ADD_USER_SUCCESS:
          return {
              ...state,
              loading: false,
              users: [...state.users, action.payload],
              error: null
          };

        case ADD_USER_FAILED:
          return {
              ...state,
              loading: false,
              error: action.payload
          };



        // --- DELETE USER ---
        case DELETE_USER:
          return {
            ...state,
            deleting: true,
            error: null
          };

        case DELETE_USER_SUCCESS:
          return {
            ...state,
            deleting: false,
            users: state.users.filter(user => user.id !== action.payload),
            error: null
          };

        case DELETE_USER_FAILED:
          return {
            ...state,
            deleting: false,
            error: action.payload
          };

        default:
          return state;
        }
};

export const rootReducer = combineReducers({
  userState: userReducer

});
