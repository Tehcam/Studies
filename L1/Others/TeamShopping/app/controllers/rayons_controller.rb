class RayonsController < ApplicationController
  before_action :set_rayon, only: %i[ show edit update destroy ]

  # GET /rayons or /rayons.json
  def index
    @rayons = Rayon.all
  end

  # GET /rayons/1 or /rayons/1.json
  def show
  end

  # GET /rayons/new
  def new
    @rayon = Rayon.new
    @rayon.items.new
  end

  # GET /rayons/1/edit
  def edit
    @rayon.items.new
  end

  # POST /rayons or /rayons.json
  def create
    @rayon = Rayon.new(rayon_params)

    respond_to do |format|
      if @rayon.save
        format.html { redirect_to @rayon, notice: "Rayon was successfully created." }
        format.json { render :show, status: :created, location: @rayon }
      else
        format.html { render :new, status: :unprocessable_entity }
        format.json { render json: @rayon.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /rayons/1 or /rayons/1.json
  def update
    respond_to do |format|
      if @rayon.update(rayon_params)
        format.html { redirect_to @rayon, notice: "Rayon was successfully updated." }
        format.json { render :show, status: :ok, location: @rayon }
      else
        format.html { render :edit, status: :unprocessable_entity }
        format.json { render json: @rayon.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /rayons/1 or /rayons/1.json
  def destroy
    @rayon.destroy
    respond_to do |format|
      format.html { redirect_to rayons_url, notice: "Rayon was successfully destroyed." }
      format.json { head :no_content }
    end
  end

  def menu
    @rayons = Rayon.all
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_rayon
      @rayon = Rayon.find(params[:id])
    end

    # Only allow a list of trusted parameters through.
    def rayon_params
      params.require(:rayon).permit(:label, items_attributes:[:id, :_destroy, :label])
    end
end
