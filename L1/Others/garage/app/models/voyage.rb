class Voyage < ApplicationRecord
    has_and_belongs_to_many :personnes

    def to_s
        [destination, " ", depart, " to ", retour].join
    end
end
