class Album < ApplicationRecord
    has_many :chansons

    def to_s 
        titre
    end
end
