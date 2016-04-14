class LineAnalyzer

	attr_reader :highest_wf_count, :highest_wf_words, :content, :line_number

	def initialize(line_number, content)
		@line_number = line_number
		@content = content
		calculate_word_frequency
	end
	

	def calculate_word_frequency()
		word_count = Hash.new(0)
		@highest_wf_words = []
		content.each { 
			|word| 
			word_count[word] += 1 
		}
		word_count = word_count.sort_by { |line, count| count }
		word_count.reverse!
		most_freq_word, @highest_wf_count = word_count.first
		word_count.each do
			|key, value|
				if value == @highest_wf_count
					@highest_wf_words << key
				end
		end
	end
end

class Solution

	attr_reader :analyzers, :highest_count_across_lines, :highest_count_words_across_lines

	def initialize
		@analyzers = []
	end

	def analyze_file
		line_count = 0
		File.foreach( 'test2.txt') do |line|
			line_count += 1
			la = LineAnalyzer.new(line_count, line.chomp.split)
			@analyzers[line_count] = la
		end
	end

	def calcualte_line_with_highest_frequency()
		line_with_highest_frequency = 0
		@highest_count_across_lines = 0
		@highest_count_words_across_lines = []
		@analyzers.each do
			|analyzer| 
			unless analyzer.nil?
				if analyzer.highest_wf_count > @highest_count_across_lines
					@highest_count_across_lines = analyzer.highest_wf_count
					line_with_highest_frequency = analyzer.line_number
				end
			end
		end
		@analyzers.each do
			| a |
			unless a.nil?
				if a.highest_wf_count == @highest_count_across_lines
					@highest_count_words_across_lines << a
				end
			end
		end
	end

	def print_highest_word_frequency_across_lines
		puts "The following words have the highest word frequency per line:"
		@highest_count_words_across_lines.each do
			| val |
			lNum = val.line_number
			freq_words = val.highest_wf_words
			puts %Q| #{freq_words} (appears in line #{lNum})|
		end
	end
end

s = Solution.new
s.analyze_file
s.calcualte_line_with_highest_frequency
s.print_highest_word_frequency_across_lines