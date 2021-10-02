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
/******/ 	return __webpack_require__(__webpack_require__.s = "./app/javascript/packs/nested_form.js");
/******/ })
/************************************************************************/
/******/ ({

/***/ "./app/javascript/packs/nested_form.js":
/*!*********************************************!*\
  !*** ./app/javascript/packs/nested_form.js ***!
  \*********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

(function ($) {
  window.NestedFormEvents = function () {
    this.addFields = $.proxy(this.addFields, this);
    this.removeFields = $.proxy(this.removeFields, this);
  };

  NestedFormEvents.prototype = {
    addFields: function addFields(e) {
      // Setup
      var link = e.currentTarget;
      var assoc = $(link).data('association'); // Name of child

      var blueprint = $('#' + $(link).data('blueprint-id'));
      var content = blueprint.data('blueprint'); // Fields template
      // Make the context correct by replacing <parents> with the generated ID
      // of each of the parent objects

      var context = ($(link).closest('.fields').closestChild('input, textarea, select').eq(0).attr('name') || '').replace(new RegExp('\[[a-z_]+\]$'), ''); // context will be something like this for a brand new form:
      // project[tasks_attributes][1255929127459][assignments_attributes][1255929128105]
      // or for an edit form:
      // project[tasks_attributes][0][assignments_attributes][1]

      if (context) {
        var parentNames = context.match(/[a-z_]+_attributes(?=\]\[(new_)?\d+\])/g) || [];
        var parentIds = context.match(/[0-9]+/g) || [];

        for (var i = 0; i < parentNames.length; i++) {
          if (parentIds[i]) {
            content = content.replace(new RegExp('(_' + parentNames[i] + ')_.+?_', 'g'), '$1_' + parentIds[i] + '_');
            content = content.replace(new RegExp('(\\[' + parentNames[i] + '\\])\\[.+?\\]', 'g'), '$1[' + parentIds[i] + ']');
          }
        }
      } // Make a unique ID for the new child


      var regexp = new RegExp('new_' + assoc, 'g');
      var new_id = this.newId();
      content = $.trim(content.replace(regexp, new_id));
      var field = this.insertFields(content, assoc, link); // bubble up event upto document (through form)

      field.trigger({
        type: 'nested:fieldAdded',
        field: field
      }).trigger({
        type: 'nested:fieldAdded:' + assoc,
        field: field
      });
      return false;
    },
    newId: function newId() {
      return new Date().getTime();
    },
    insertFields: function insertFields(content, assoc, link) {
      var target = $(link).data('target');

      if (target) {
        return $(content).appendTo($(target));
      } else {
        return $(content).insertBefore(link);
      }
    },
    removeFields: function removeFields(e) {
      var $link = $(e.currentTarget),
          assoc = $link.data('association'); // Name of child to be removed

      var hiddenField = $link.prev('input[type=hidden]');
      hiddenField.val('1');
      var field = $link.closest('.fields');
      field.hide();
      field.trigger({
        type: 'nested:fieldRemoved',
        field: field
      }).trigger({
        type: 'nested:fieldRemoved:' + assoc,
        field: field
      });
      return false;
    }
  };
  window.nestedFormEvents = new NestedFormEvents();
  $(document).delegate('form a.add_nested_fields', 'click', nestedFormEvents.addFields).delegate('form a.remove_nested_fields', 'click', nestedFormEvents.removeFields);
})(jQuery); // http://plugins.jquery.com/project/closestChild

/*
 * Copyright 2011, Tobias Lindig
 *
 * Dual licensed under the MIT (http://www.opensource.org/licenses/mit-license.php)
 * and GPL (http://www.opensource.org/licenses/gpl-license.php) licenses.
 *
 */


(function ($) {
  $.fn.closestChild = function (selector) {
    // breadth first search for the first matched node
    if (selector && selector != '') {
      var queue = [];
      queue.push(this);

      while (queue.length > 0) {
        var node = queue.shift();
        var children = node.children();

        for (var i = 0; i < children.length; ++i) {
          var child = $(children[i]);

          if (child.is(selector)) {
            return child; //well, we found one
          }

          queue.push(child);
        }
      }
    }

    return $(); //nothing found
  };
})(jQuery);

/***/ })

/******/ });
//# sourceMappingURL=nested_form-e3a7638b057f5f050a20.js.map