# clj-pedestal-reload-practice

Sample app to auto reload pedestal by changing code for development.

## Requirements

- clojure cli

## Usage

Run main.
```
clj -M:run-m
```

Run development mode to watch src dir.
```
clj -X:dev
```

## License

Copyright © 2022 Asuki
Distributed under the Eclipse Public License version 1.0.

## References
- [Watch and auto reload a Clojure pedestal service on source change](https://dev.to/praburajan/watch-and-auto-reload-a-clojure-pedestal-service-on-save-4ehl)
- [pedestal/samples/auto-reload-server/dev/dev.clj](https://github.com/pedestal/samples/blob/master/auto-reload-server/dev/dev.clj)
- [Clojureサービス開発ライブラリPedestal入門](https://qiita.com/lagenorhynque/items/fbd66ebaa0352ec4253d)
