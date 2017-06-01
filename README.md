# Leiningen validation benchmark

A benchmark between spec, schema and truss in how fast they can
validate a leiningen project file.

## Usage

This package depends on you having gnuplot installed on your machine
as well as GNU Make and a POSIX compliant OS, i.e. not Windows.

In order to run the benchmark, enter `lein run` into your terminal and
at the end you'll find a bunch of fresh charts in `plot/charts`.

## Documentation

### Getting test data
Build up your local maven cache using the [all the clojars][] project,
then run `extract-project-files-from-local-maven-cache.bash`.

[all the clojars]: https://github.com/Rovanion/all-the-clojars



## License

Copyright © 2017 Rovanion Luckey

Distributed under the AGPL https://www.gnu.org/licenses/agpl-3.0.en.html
