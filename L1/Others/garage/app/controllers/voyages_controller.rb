class VoyagesController < ApplicationController
  before_action :set_voyage, only: %i[ show edit update destroy ]

  # GET /voyages or /voyages.json
  def index
    @voyages = Voyage.all
  end

  # GET /voyages/1 or /voyages/1.json
  def show
  end

  # GET /voyages/new
  def new
    @voyage = Voyage.new
  end

  # GET /voyages/1/edit
  def edit
  end

  # POST /voyages or /voyages.json
  def create
    @voyage = Voyage.new(voyage_params)

    respond_to do |format|
      if @voyage.save
        format.html { redirect_to @voyage, notice: "Voyage was successfully created." }
        format.json { render :show, status: :created, location: @voyage }
      else
        format.html { render :new, status: :unprocessable_entity }
        format.json { render json: @voyage.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /voyages/1 or /voyages/1.json
  def update
    respond_to do |format|
      if @voyage.update(voyage_params)
        format.html { redirect_to @voyage, notice: "Voyage was successfully updated." }
        format.json { render :show, status: :ok, location: @voyage }
      else
        format.html { render :edit, status: :unprocessable_entity }
        format.json { render json: @voyage.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /voyages/1 or /voyages/1.json
  def destroy
    @voyage.destroy
    respond_to do |format|
      format.html { redirect_to voyages_url, notice: "Voyage was successfully destroyed." }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_voyage
      @voyage = Voyage.find(params[:id])
    end

    # Only allow a list of trusted parameters through.
    def voyage_params
      params.require(:voyage).permit(:destination, :depart, :retour, personne_ids:[])
    end
end
