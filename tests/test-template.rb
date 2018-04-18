test_dir = "tests/" + proj_name
proj_dir = "samples/" + proj_name
package_name = "samples." + proj_name
proj_main_src_abspath = Dir["#{PLHAM_DIR}/#{proj_dir}/*Main.java"].first
proj_main_src = proj_main_src_abspath.split("/").last
proj_main = proj_main_src.chomp(".java")
test_configs = Dir["#{PLHAM_DIR}/#{test_dir}/config*.json"]

Dir.chdir(PLHAM_DIR)

test_configs.each do |test_config|
  test_id = test_config.match(/^.+config(?<id>.*)\.json$/)[:id] || ""
  conf_name = "config#{test_id}.json"
  correct_output_file = "#{test_dir}/correct_output#{test_id}.txt"
  program_output_file = "#{test_dir}/program_output#{test_id}.txt"
  seed = 100

  File.delete(program_output_file)
  run_cmd = "#{RUN} #{package_name}.#{proj_main} #{test_config} #{seed}"
  STDERR.puts("#{run_cmd}")
  output = `#{run_cmd}`.lines("\n").select{|line| /^[^#-]/.match(line) }.join
  
  File.write(program_output_file, output)
  
  correct_output = File.read(correct_output_file)
  if output == correct_output
      STDERR.puts "#{proj_name}/#{conf_name} OK."
  else
      STDERR.puts "#{proj_name}/#{conf_name} FAILED"
  end
end


Dir.chdir(test_dir)

