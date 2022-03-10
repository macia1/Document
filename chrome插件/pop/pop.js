var pop = function() {
    'use strict';
    alert(new Date());
};
var hook_tab = document.createElement('script');
hook_tab.textContent = '(' + pop + ')()';
(document.head || document.documentElement).appendChild(hook_tab);
hook_tab.parentNode.removeChild(hook_tab);