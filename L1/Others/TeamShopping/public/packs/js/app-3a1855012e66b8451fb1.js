/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, { enumerable: true, get: getter });
/******/ 		}
/******/ 	};
/******/
/******/ 	// define __esModule on exports
/******/ 	__webpack_require__.r = function(exports) {
/******/ 		if(typeof Symbol !== 'undefined' && Symbol.toStringTag) {
/******/ 			Object.defineProperty(exports, Symbol.toStringTag, { value: 'Module' });
/******/ 		}
/******/ 		Object.defineProperty(exports, '__esModule', { value: true });
/******/ 	};
/******/
/******/ 	// create a fake namespace object
/******/ 	// mode & 1: value is a module id, require it
/******/ 	// mode & 2: merge all properties of value into the ns
/******/ 	// mode & 4: return value when already ns object
/******/ 	// mode & 8|1: behave like require
/******/ 	__webpack_require__.t = function(value, mode) {
/******/ 		if(mode & 1) value = __webpack_require__(value);
/******/ 		if(mode & 8) return value;
/******/ 		if((mode & 4) && typeof value === 'object' && value && value.__esModule) return value;
/******/ 		var ns = Object.create(null);
/******/ 		__webpack_require__.r(ns);
/******/ 		Object.defineProperty(ns, 'default', { enumerable: true, value: value });
/******/ 		if(mode & 2 && typeof value != 'string') for(var key in value) __webpack_require__.d(ns, key, function(key) { return value[key]; }.bind(null, key));
/******/ 		return ns;
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "/packs/";
/******/
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = "./app/javascript/packs/app.js");
/******/ })
/************************************************************************/
/******/ ({

/***/ "./app/javascript/packs/app.js":
/*!*************************************!*\
  !*** ./app/javascript/packs/app.js ***!
  \*************************************/
/*! no static exports found */
/***/ (function(module, exports) {

var pubnub;

function letsGo() {
  pubnub = new PubNub({
    publishKey: "pub-c-9ce10d1f-f958-426a-bd74-849e495aa82b",
    subscribeKey: "sub-c-828cd53c-bfc3-11eb-aee1-fe487e55b6a4",
    uuid: "sec-c-YzNmMTViY2EtNTgwZS00Y2FkLTllOWEtYWQ4MDdiNjQyYmEw"
  });
  pubnub.addListener({
    status: function status(statusEvent) {
      console.log('Pubnub ready !');
    },
    message: function message(msg) {
      console.log('notification from pubnub');
      var ref = '#' + msg.message.id;
      console.log($(ref));
      $(ref).checked = true;
      alert(msg.message.title + '\n' + msg.message.content);
    }
  });
  pubnub.subscribe({
    channels: ["courses"]
  });
} // function postNotification(item, status)
// {
//     var notification = {
//         title: "TeamShopping",
//         content: status ? (item + " vient d'être acheté !") : (item + " n'est pas encore acheté(e) !")
//     }
//     console.log(notification.title)
//     console.log(notification.content)
//     pubnub.publish({
//         message: notification,
//         channel: "courses"
//     })
// }


$('.checkbox').on('click', function (e) {
  e.preventDefault();
  var authenticity = $('input[name="authenticity_token"]')[0].defaultValue;
  var bool = e.currentTarget.checked;
  var mydata;
  if (bool) mydata = {
    "authenticity_token": authenticity,
    "is_already_bought": true
  };else mydata = {
    "authenticity_token": authenticity,
    "is_already_bought": false
  };
  $.ajax({
    type: 'PATCH',
    url: '/items/label/' + e.currentTarget.dataset.label + '.json',
    success: function success(res) {
      console.log('success');
    },
    dataType: 'json',
    data: mydata
  });
});
letsGo();

/***/ })

/******/ });
//# sourceMappingURL=app-3a1855012e66b8451fb1.js.map