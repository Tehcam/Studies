class Artiste < ApplicationRecord
    has_many :chansons

    def to_s
        nom
    end
end
