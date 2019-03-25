#!/usr/bin/env node

const replace = require('replace-in-file');

const changes = replace.sync({
    files: 'node_modules/@vaadin/*/package.json',
    from: '"main"',
    to: '"module"',
  });
  
//  console.log(changes);
