import { call, put, takeEvery, takeLatest } from 'redux-saga/effects';
import * as userService from '../service/UserService.js';
import {
    GET_USERS,
    getUsers,
    getUsersSuccess,
    getUsersFailed,
    ADD_USER,
    addUserSuccess,
    addUserFailed,
    DELETE_USER,
    deleteUserSuccess,
    deleteUserFailed
} from '../redux/action.jsx';
import { toast } from 'react-toastify';

function* getUsersSaga() {
  try {
    const users = yield call(userService.findAll);
    yield put(getUsersSuccess(users));
  } catch (error) {
    console.error('Error fetching users:', error);
    yield put(getUsersFailed(error.message));
    toast.error('Không thể tải danh sách người dùng!');
  }
}

function* addUserSaga(action) {
    try {
        yield call(userService.addUser, action.payload);
        toast.success("Thêm người dùng thành công")
        yield put(getUsers());
    } catch (error) {
        console.error('Error adding user:', error);
        yield put(addUserFailed(error.message));
        toast.error("Thêm người dùng thất bại")
    }
}


function* deleteUserSaga(action) {
  try {
    const userId = action.payload;
    const response = yield call(userService.deleteUser, userId);
    
    yield put(deleteUserSuccess(userId));

    // Display success with status code
    toast.success(`Xóa người dùng thành công! (Status: ${response.status} ${response.statusText})`);

    yield put(getUsers());
    
  } catch (error) {
    console.error('Error deleting user:', error);
    yield put(deleteUserFailed(error.message));
    
    // Display error with status code
    const errorMsg = error.response 
      ? `Xóa người dùng thất bại! (Status: ${error.response.status} - ${error.response.statusText})`
      : 'Xóa người dùng thất bại! Không thể kết nối đến server.';
    
    toast.error(errorMsg);
  }
}

function* watchUserSaga() {
  yield takeLatest(GET_USERS, getUsersSaga);
  yield takeEvery(ADD_USER, addUserSaga);
  yield takeEvery(DELETE_USER, deleteUserSaga);
}

export default function* rootSaga() {
  yield watchUserSaga();
}
