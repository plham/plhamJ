# A test script for plham's sample projects.
# 
# It runs all 'test.rb' under the plham/tests directory (recursively).
#
# To run tests for samples/SomeExperiments, make directory named tests/SomeExperiments, copy tests/test-template.rb to tests/SomeExperiments, 
# and place config.json and correct_output.txt under test/SomeExperiments.

PLHAM_DIR = File.expand_path("..")
PLHAM_TEST_DIR = File.expand_path(".")
PLHAM_SAMPLES_DIR = File.expand_path("../samples")

ENV["PLHAM_DIR"] = PLHAM_DIR
ENV["PLHAM_TEST_DIR"] = PLHAM_TEST_DIR

ant = `cd ../ && ant && cd tests/`
puts ant
RUN = "java -cp " + PLHAM_DIR + ":" + PLHAM_DIR + "/lib/x10.jar "

def dfs(dir)
    dir.chomp!("/")
    Dir.entries(dir).each do |elem|
        next if elem.start_with?('.')
        elem = File.expand_path(elem, dir)
        if File.directory?(elem) then
            dfs(elem)
        elsif elem.end_with?("test.rb")
            proj_name = dir.split("/").last
            eval(File.read(File.realpath(elem)))
        end
    end
end

dfs(PLHAM_TEST_DIR)
